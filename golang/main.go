package main

import (
	"github.com/joho/godotenv"
	log "github.com/sirupsen/logrus"
)

func main() {
	// Load environment
	err := godotenv.Load()

	if err != nil {
		log.WithError(err).Fatal("An error occurred while loading the environment variables")
	}
}
