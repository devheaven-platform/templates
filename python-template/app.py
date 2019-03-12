'''
File: app.py
Description: Contains functions to create & start the Flask server.
'''
import os
from flask import Flask
from flask_cors import CORS
from dotenv import load_dotenv, find_dotenv
from models import mongo
from views import health
from views.errors import bad_request, not_found, internal_server_error, unauthorized
from config import setup_logging

load_dotenv(find_dotenv())

# Setup environment & logging
setup_logging()


def start_app(app=None):
    '''
    Starts the given application. If the application isn't present a new one is created.

    Args:
      app: Application that will be started.
    '''
    if not app:
        app = create_app()

    host = os.getenv('FLASK_HOST')
    port = os.getenv('FLASK_PORT')
    app.run(host=host, port=port, threaded=True)


def create_app():
    '''
    Creates a new application and adds and initializes an api with all namespaces.

    Returns:
      Newly created application.
    '''
    app = Flask(__name__, static_url_path='', static_folder='../client/build')
    app.config['SECRET_KEY'] = os.getenv('SECRET_KEY')
    app.config['MONGODB_SETTINGS'] = {
        'db': os.getenv('MONGO_DB'),
        'host': os.getenv('MONGO_URI')
    }

    # Register routes
    app.register_blueprint(health, url_prefix='/api/v1/')

    # Register errors
    app.register_error_handler(400, bad_request)
    app.register_error_handler(401, unauthorized)
    app.register_error_handler(404, not_found)
    app.register_error_handler(500, internal_server_error)

    # Init db
    mongo.init_app(app)

    # Setup CORS
    CORS(app)

    return app


if __name__ == '__main__':
    flask_app = create_app()
    start_app(flask_app)
