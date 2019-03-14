using System.Collections.Generic;
using Newtonsoft.Json;

namespace AspTemplate.Models
{
    public class Error
    {
        [JsonProperty("name")]
        public string Name { get; private set; }

        [JsonProperty("status")]
        public int Status { get; private set; }

        [JsonProperty("message")]
        public string Message { get; private set; }

        [JsonProperty("errors", NullValueHandling=NullValueHandling.Ignore)]
        public Dictionary<string, string> Errors { get; private set; }

        public Error(string name, int status, string message) {
            this.Name = name;
            this.Status = status;
            this.Message = message;
        }

        public Error(string name, int status, string message, Dictionary<string, string> errors) {
            this.Name = name;
            this.Status = status;
            this.Message = message;
            this.Errors = errors;
        }
    }
}
