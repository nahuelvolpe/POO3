using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace MVC.Controllers
{
    public class ProyectosController : Controller
    {
        public IActionResult Index()
        {
            ViewBag.nombre = "Nahuel";
            return View();
        }
    }
}