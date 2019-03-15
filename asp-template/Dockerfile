# Builder
FROM microsoft/dotnet:sdk AS builder

# Set working directory
WORKDIR /app

# Copy csproj
COPY *.csproj /app/

# Restore layers
RUN dotnet restore

# Copy source
COPY . /app/

# Build the binary
RUN dotnet publish -c Release -o out

# Worker
FROM microsoft/dotnet:aspnetcore-runtime

# Set working directory
WORKDIR /app

# Copy binary
COPY --from=builder /app/out .

# Run binary
ENTRYPOINT ["dotnet", "asp-template.dll"]