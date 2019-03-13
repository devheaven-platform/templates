package main

import (
	"os"

	"github.com/joho/godotenv"
	log "github.com/sirupsen/logrus"
)

func main() {
	// Load environment
	if os.Getenv("GO_ENV") == "development" {
		err := godotenv.Load()

		if err != nil {
			log.WithError(err).Fatal("An error occurred while loading the environment variables")
		}
	}

	host := os.Getenv("HOSTNAME")
	port := os.Getenv("PORT")

	log.WithFields(log.Fields{
		"host": host,
		"port": port,
	}).Info("Starting server")
}
