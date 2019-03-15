using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Logging;

namespace AspTemplate
{
    public class Program
    {
        public static void Main(string[] args)
        {
            if (File.Exists(".env"))
            {
              DotNetEnv.Env.Load();
            }

            string host = System.Environment.GetEnvironmentVariable("ASP_HOST");
            string port = System.Environment.GetEnvironmentVariable("ASP_PORT");

            CreateWebHostBuilder(args, host, port).Build().Run();
        }

        public static IWebHostBuilder CreateWebHostBuilder(string[] args, string host, string port) => WebHost
            .CreateDefaultBuilder(args)
            .UseStartup<Startup>()
            .UseUrls($"http://{host}:{port}");
    }
}
