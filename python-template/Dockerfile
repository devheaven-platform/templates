FROM python:2.7

# Set working directory
WORKDIR /app

# Copy requirements
COPY requirements.txt /app/requirements.txt

# Install requirements
RUN pip install -r requirements.txt

# Add app code
ADD . /app

# Expose port
EXPOSE 5000

# Run server
CMD ["python", "app.py"] 