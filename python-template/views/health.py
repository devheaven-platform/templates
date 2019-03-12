'''
File: health.py
Description: Contains the blueprint for the health in k8s.
'''
from http import HTTPStatus
from flask import Blueprint, jsonify

health = Blueprint('health', __name__)


@health.route('/health')
def get():
    '''
    Used by kubernets to check the health of the container

    Returns:
      200 status code
    '''
    return jsonify({
        'name': 'Health',
        'message': 'The container is running',
        'status': HTTPStatus.OK
    }), HTTPStatus.OK
