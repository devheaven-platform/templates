FROM python:3.6

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

# Run server (not using gunicorn to expose prometheus metrics)
CMD ["python", "app.py"]