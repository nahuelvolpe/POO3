using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    abstract class Elemento 
    {
        protected string name;
        public Elemento(string name)
        {
            this.name = name; 
        }
        public abstract void Agregar(Elemento e);
        public abstract void Eliminar(Elemento e);
        public abstract void Mostrar();
    }


}
