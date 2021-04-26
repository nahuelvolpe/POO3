using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;
using System.IO;


namespace Cliente
{
    public class Cliente
    {
        TcpClient socket = new TcpClient();
        NetworkStream ns = null;
        StreamReader input = null;
        StreamWriter output = null;
        String respuesta = "";
        String res = "";
        String ack1 = "";
        String ack2 = "";

        public Cliente(){
            try
            {
                this.iniciar();
            }
            catch (Exception e) {
                e.ToString();
            }
        }

        public void iniciar() {
         
            socket.Connect("localhost", 5550);
            ns = socket.GetStream();
            input = new StreamReader(ns);
            output = new StreamWriter(ns);
            
            Console.Write("Metodo iniciar() ejecutado\n");
        }


        public void test() {
            Console.Write("Verificando usuario...\n");
            byte[] user = Encoding.ASCII.GetBytes("nahuel\n");
            byte[] pass = Encoding.ASCII.GetBytes("volpe\n");

            ns.Write(user, 0, user.Length);
            ns.Write(pass, 0, pass.Length);

            Console.Write("La resputa del servidor es: \n");

            respuesta = input.ReadLine();
            Console.WriteLine(respuesta);
        }


        public Boolean verificarUsuario(String usuario, String contraseña)
        {
            Console.Write("Verificando usuario...\n");
            Boolean condicion = false;
            byte[] user = Encoding.ASCII.GetBytes(usuario + "\n");
            byte[] pass = Encoding.ASCII.GetBytes(contraseña + "\n");

            Console.Write(usuario + " " + contraseña + "\n");

            ns.Write(user, 0, user.Length);
            //ack1 = input.ReadLine();
            //Console.Write(ack1 + "\n");

            ns.Write(pass, 0, pass.Length);
            //ack2 = input.ReadLine();
            //Console.Write(ack2 + "\n");

            Console.Write("La respuesta del servidor es: \n");

            respuesta = input.ReadLine();
            Console.WriteLine(respuesta);
            
            if (respuesta.Equals("0"))
            {
                condicion = true;
            }
            else if (respuesta.Equals("1"))
            {
                condicion = false;
                Console.Write("El usuario no existe o esta mal escrito\n");
            }
            else
            {
                Console.Write("La respuesta no fue ni 0, ni 1\n");
            }

            return condicion;
        }

        public void enviarMensaje(String mensaje) {
            byte[] msg = Encoding.ASCII.GetBytes(mensaje + "\n");
            ns.Write(msg, 0, msg.Length);
        }

        public String recibirMensaje()
        {
            res = input.ReadLine();
            return res;
        }
    }
}
