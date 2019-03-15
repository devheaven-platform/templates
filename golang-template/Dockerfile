# Builder
FROM golang:1.12.0-alpine3.9 as builder

# Set working directory
WORKDIR /app

# Copy mod & sum files
COPY go.mod /app/go.mod
COPY go.sum /app/go.sum

# Install dependencies
RUN apk add --no-cache git
RUN go mod download

# Copy source
COPY . /app

# Build the binary
RUN CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build -a -installsuffix cgo -o /app/bin/service

# Worker
FROM scratch

# Copy binary
COPY --from=builder /app/bin/service /app/bin/service

# Run binary
ENTRYPOINT ["/app/bin/service"]