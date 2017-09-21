"""
Clase que recibe la ruta de un archivo .py con el contenido de un programa en python,
y realiza un conteo de la cantidad de clases, métodos por clase, cantidad de líneas por clase,
cantidad de comentarios del módulo.
Author: Viviana Londoño, Yeifer Herrera, Oscar Lopera
"""

class cls_contar:

    '''
    Método constructor
    Params: path_archivo, Ruta del archivo a leer
    '''
    def __init__(self,path_archivo):
        self.path_archivo_auxiliar=path_archivo
        if(self.met_verificar_extension(path_archivo)==True):
            try:
                self.archivo=open(self.path_archivo_auxiliar)
                self.int_numero_comentario=0
                self.bl_bandera=0
                self.int_clases=0
                self.array_nombre_clases=["","","","",""]
                self.str_nombre_clase=""
                self.int_lineas=0
                self.int_metodos=0
                self.array_numero_metodos=[0,0,0,0,0]
                self.array_numero_lineas=[0,0,0,0,0]
                self.int_clases=0

            except IOError:
                print("El archivo no pudo ser leido")
                exit()
        else:
            pass

    #Método para verificar la extensión del archivo a procesar
    #Params: vm_ruta_archivo, Ruta del archivo
    #Return: vr_resultado, Variable booleana que retorna true si la extensión es correcta, o false en caso contrario
    def met_verificar_extension(self, vm_ruta_archivo):
        str_extension=""
        vr_resultado=True
        str_extension = vm_ruta_archivo[-3:]
        if len(str_extension)<3:
            print("Error con la ruta o nombre del archivo ")
            vr_resultado=False
            pass

        elif str_extension!=".py":
            print("La extension del archivo no es correcta")
            vr_resultado=False
            pass

        return vr_resultado

    # Método para realizar el conteo de líeas de código, comentarios, clases y métodos.
    # Params:
    # Return: int_clases, int_numero_comentario, array_nombre_clases, array_numero_lineas, array_numero_metodos
    def met_contar(self):

        for str_linea in self.archivo.readlines():
            if str_linea != "\n":
                str_linea = str_linea.strip()

                if str_linea[0:3] == '"""':
                    self.bl_bandera = 1
                    self.int_numero_comentario = self.int_numero_comentario + 1

                    if str_linea[-3:] == '"""':
                        self.bl_bandera = 0

                elif str_linea[-3:] == '"""':
                    self.bl_bandera = 0

                elif self.bl_bandera == 0:

                    str_linea = str_linea.replace(" ", "")

                    if str_linea[0:8] == "classcls":
                        self.int_clases = self.int_clases + 1
                        self.str_nombre_clase = str_linea[9:-1]
                        x=self.int_clases
                        self.array_nombre_clases[x]=self.str_nombre_clase
                        self.array_numero_lineas.append(0)
                        self.int_lineas = 0

                    elif (str_linea[0:6] == "defmet") or (str_linea[0:7] == "deftest"):
                        self.int_metodos = self.int_metodos + 1
                        x = self.int_clases
                        self.array_numero_metodos[x] = self.int_metodos
                    elif str_linea[0:3] == "for":
                        self.int_lineas = self.int_lineas + 2
                    self.int_lineas = self.int_lineas + 1
                    x=self.int_clases
                    self.array_numero_lineas[x] = self.int_lineas

        return self.int_clases, self.int_numero_comentario, self.array_nombre_clases, self.array_numero_lineas,self.array_numero_metodos

    #Método para mostrar en pantalla el resultado
    def met_muestre(self):

        int_mostrar_clases=1

        x=self.int_clases
        while int_mostrar_clases <= x:
            print("\nClase:",self.array_nombre_clases[int_mostrar_clases])
            print("Numero de lineas en la clase:",self.array_numero_lineas[int_mostrar_clases])
            print("Numero de metodos en la clase:",self.array_numero_metodos[int_mostrar_clases])
            int_mostrar_clases = int_mostrar_clases + 1
        print("Numero de clases: ",self.int_clases)
        print("Numero de Comentario: ",self.int_numero_comentario)


objetoContar=cls_contar("Test.py")

array_valores=[0,0,[],[],[]]
array_valores=objetoContar.met_contar()

print(array_valores)
objetoContar.met_muestre()
