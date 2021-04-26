using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class ElementoHoja:Elemento
    {
        public ElementoHoja(string name)
            : base(name)
        { }
        public override void Agregar(Elemento e)
        {
            Console.WriteLine("No se puede añadir a una Hoja");
        }
        public override void Eliminar(Elemento e)
        {
            Console.WriteLine("No se puede eliminar de una Hoja");
        }
        public override void Mostrar()
        {
            Console.WriteLine(name);
        }
    }
}
