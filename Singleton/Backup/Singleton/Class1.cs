using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Singleton
    {
        private static Singleton instance = null;
        private Singleton() { }
        
        public static Singleton GetInstance()
        {
            if (instance == null)
                instance = new Singleton();
            Console.Write("Instancia Creada");
            Console.ReadKey(); 
            return instance;
        }
    }
}