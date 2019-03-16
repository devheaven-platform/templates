package main

import (
	"net/http"
	"os"

	"github.com/joho/godotenv"
	"github.com/prometheus/client_golang/prometheus/promhttp"
	log "github.com/sirupsen/logrus"
)

func main() {
	// Load environment
	err := godotenv.Load()

	if err != nil {
		log.WithError(err).Fatal("An error occurred while loading the environment variables")
	}

	host := os.Getenv("GO_HOST")
	port := os.Getenv("GO_PORT")

	// Add prometheus
	http.Handle("/metrics", promhttp.Handler())

	log.WithFields(log.Fields{
		"host": host,
		"port": port,
	}).Info("Starting server")
	log.Fatal(http.ListenAndServe(host+":"+port, nil))
}
