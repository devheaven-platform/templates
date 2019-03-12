package models

type Error struct {
	Name    string            `json:"name"`
	Message string            `json:"message"`
	Status  int               `json:"status"`
	Errors  map[string]string `json:"errors,omitempty"`
}
