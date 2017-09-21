
import unittest
import Programa2

"""
Clase para realizar las pruebas al programa2 y sus métodos
Author: Viviana Londoño, Yeifer Herrera, Oscar Lopera
""" 
class cls_Contar_Test_Case(unittest.TestCase):


    #Pruebas para el método verificar extensión cuando se ingresa la ruta con extensión correcta
    def test_met_verificar_extension(self):
        self.contar = Programa2.cls_contar("Suma.py")
        self.respuesta=self.contar.met_verificar_extension("Suma.py")
        self.assertEqual(True, self.respuesta)

    #Pruebas para el método verificar extensión cuando se ingresa la ruta con extensión errada
    def test_met_verificar_extension_errada(self):
        self.contar = Programa2.cls_contar("Suma.txt")
        self.respuesta=self.contar.met_verificar_extension("Suma.txt")
        self.assertEqual(True, self.respuesta)

        #Pruebas para el método verificar extensión cuando se ingresa la ruta con extensión errada
    def test_met_verificar_extension_no_existe(self):
        self.contar = Programa2.cls_contar("NoExiste.py")
        self.respuesta=self.contar.met_verificar_extension("NoExiste.py")
        self.assertEqual(True, self.respuesta)

	#Pruebas para el método contar cuando se ingresa un archivo existente y correcto
    def test_met_contar_correcto(self):
        self.lopera = Programa2.cls_contar("Suma.py")
        self.array_valores=self.lopera.met_contar()

	#Pruebas para el método contar cuando se ingresa un archivo existente pero vacío
   	def test_met_contar_vacio(self):
   		self.lopera1 = Programa2.cls_contar("Vacio.py")
   		self.array_valores=self.lopera1.met_contar()

   	#Pruebas para el método contar cuando se ingresa un archivo existente pero con información cualquiera
   	def test_met_contar_no_existe(self):
   		self.lopera1 = Programa2.cls_contar("NoExiste.py")
   		self.array_valores=self.lopera1.met_contar()

   	#Pruebas para el método contar cuando se ingresa un archivo existente pero vacío
    def test_met_contar_info_diferente(self):
        self.respuesta = Programa2.cls_contar("InfoDiferente.py")
        self.array_valores=self.respuesta.met_contar()

    

if __name__ == "__main__":
   unittest.main()
