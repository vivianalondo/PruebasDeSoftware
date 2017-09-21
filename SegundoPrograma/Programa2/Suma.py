"""Programa 2
En este programa se realiza el calculo de la suma de 2 numeros y el factorial de 1 de ellos
Autor:Oscar Lopera y los Amiguitos"""
class cls_hola:

    def met_sandra(x):
        return print("Este man no la deja quieta"+x)
    def met_lop(y):
        return print(y)
    def met_vivi(z):
        return print(z)

class cls_ejemplo:

    """En este metodo se realiza la suma de 2 numeros.
    Parametros: Los 2 numeros que se desan sumar (numero1,numero2)
    Returno: El numero que se optubo como resultado de la suma de los numeros de entrada (sumanum)"""

    def met_suma(vm_numero_1, vm_numero_2):
        vr_suma_numeros = vm_numero_1 + vm_numero_2
        return vr_suma_numeros

    """En este metodo se realiza el factroail de 1 numero.
    Parametro: 1 numero("numero1")
    Retorno: El numero que optube el metodo al calcular el factroial del numero de entrada(factorial)"""

    def met_factorial(vr_numero1):
        """La variable contador se utilizar para identificar los numeros factoriales de un numero"""

        int_contador = 1

        """Esta variable se utiliza para ir acumulando los resultados optenidos durante el calculo del factorial y,
         dar el valor factorial de una entrada"""

        vr_factorial = 1

        while int_contador <= vr_numero1:
            vr_factorial = vr_factorial * int_contador
            int_contador = int_contador + 1
        return vr_factorial

    """Esta variable identifica el primero numero con el cual se realizara la suma y se calculara el factorial"""

    int_numero1=5

    """Esta variable identifica el segundo numero con el cual se realizara la suma"""

    int_numero2=10

    """Documentar las variables"""
    int_resultado_suma = met_suma(int_numero1,int_numero2)
    int_resultado_factorial = met_factorial(int_numero1)

    print(int_resultado_suma)
    print(int_resultado_factorial)
