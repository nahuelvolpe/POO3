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
            client = new Cliente(this);
        }

      

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            Console.Write("Boton Enviar ha sido clicleado\n");
            if (client.verificarUsuario(textBox1.Text, textBox2.Text))
            {
                label1.Visible = false;
                label2.Visible = false;
                textBox1.Visible = false;
                textBox2.Visible = false;
                button1.Visible = false;
                button2.Visible = false;
                listBox1.Visible = true;
                textBox3.Visible = true;
                button3.Visible = true;
                client.startThread();
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

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            client.enviarMensaje(textBox3.Text);
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        public void setListBox1(String s)
        {
            listBox1.Items.Add(s);
        }
    }
}
