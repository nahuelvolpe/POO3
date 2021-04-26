using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;

using System.Net.Sockets;
using System.IO;
using System.Windows.Forms;
using System.Threading;


namespace Cliente
{
    public class Cliente
    {
        Form1 form = null;
        TcpClient socket = new TcpClient();
        NetworkStream ns = null;
        StreamReader input = null;
        StreamWriter output = null;
        delegate void DAddItem(string s);
        Thread t = null;

        String respuesta = "";
        String res = "";
        String ack1 = "";
        String ack2 = "";

        public Cliente(Form1 formulario){
            try
            {
                this.form = formulario;
                this.iniciar();
            }
            catch (Exception e) {
                e.ToString();
            }
        }

        public void iniciar() {
            try
            {
                socket.Connect("localhost", 5550);
                if (socket.Connected)
                {
                    t = new Thread(listen);
                    ns = socket.GetStream();
                    input = new StreamReader(ns);
                    output = new StreamWriter(ns);
                    Console.Write("Metodo iniciar() ejecutado\n");
                }
                else
                {
                    MessageBox.Show("Servidor no responde");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Servidor no responde");
                Application.Exit();
            }

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

        private void AddItem(String s)
        {
            form.setListBox1(s);
        }
        public void listen() {
            while (socket.Connected)
            {
                try
                {
                    form.Invoke(new DAddItem(AddItem), input.ReadLine());
                }
                catch
                {
                    MessageBox.Show("No se ha podido conectar al servidor");
                    Application.Exit();
                }
            }
        }

        public void startThread() {
            t.Start();
        }
        public void enviarMensaje(String mensaje) {
            byte[] msg = Encoding.ASCII.GetBytes(mensaje + "\n");
            ns.Write(msg, 0, msg.Length);
        }
    }
}
