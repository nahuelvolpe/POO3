using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cliente
{
    public partial class Form1 : Form
    {
        Cliente client = null;

        public Form1()
        {
            InitializeComponent();
            client = new Cliente();
        }

      

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //client.test();
            
            Console.Write("Boton Enviar ha sido clicleado\n");
            if (client.verificarUsuario(textBox1.Text, textBox2.Text))
            {
                Chat enter = new Chat();
                enter.setCliente(client);
                enter.Show();
            }
            else
            {
                MessageBox.Show("Usuario o contraseña incorrecto, por favor intente denuevo");
            }
            
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        
    }
}
