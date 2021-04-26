using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class ElementoComp : Elemento 
    {
        private List<Elemento> hojas = new List<Elemento>();

        public ElementoComp(string name)
            : base(name)
        { }

        public override void Agregar(Elemento e)
        {
            hojas.Add(e);
        }
        public override void Eliminar(Elemento e)
        {
            hojas.Remove(e);
        }
        public override void Mostrar()
        {
            Console.WriteLine(name);
            foreach (Elemento e in hojas)
            {
                e.Mostrar(); 
            }
        }    }}