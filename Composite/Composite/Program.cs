using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            Elemento raiz = new ElementoComp("raiz");
            Elemento hoja1 = new ElementoHoja("hoja1");
            raiz.Agregar(hoja1); 
            Elemento otro = new ElementoComp("otro");
            Elemento hoja2 = new ElementoHoja("hoja2");
            otro.Agregar(hoja2);
            raiz.Agregar(otro);
            raiz.Mostrar();
            hoja1.Agregar(otro); 
            Console.ReadKey();
        }
    }
}
