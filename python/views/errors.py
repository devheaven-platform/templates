'''
File: errors.py
Description: Overwrites various general error handlers.
'''
from http import HTTPStatus
from flask import jsonify


def bad_request(_):
    '''
    Handles the bad request errors.

    Args:
      error: the error object.

    Returns:
      An JSON representation of the error.
    '''
    return jsonify({
        'name': 'BadRequest',
        'message': 'Invalid request',
        'status': HTTPStatus.BAD_REQUEST
    }), HTTPStatus.BAD_REQUEST


def not_found(_):
    '''
    Handles the not found errors.

    Args:
      error: the error object.

    Returns:
      An JSON representation of the error.
    '''
    return jsonify({
        'name': 'NotFound',
        'message': 'Resource Not Found',
        'status': HTTPStatus.NOT_FOUND
    }), HTTPStatus.NOT_FOUND


def internal_server_error(_):
    '''
    Handles the internal server errors.

    Args:
      error: the error object.

    Returns:
      An JSON representation of the error.
    '''
    return jsonify({
        'name': 'InternalServerError',
        'message': 'An error ocurred',
        'status': HTTPStatus.INTERNAL_SERVER_ERROR
    }), HTTPStatus.INTERNAL_SERVER_ERROR


def unauthorized(_):
    '''
    Handles the unauthorized errors.

    Args:
      error: the error object.

    Returns:
      An JSON representation of the error.
    '''
    return jsonify({
        'name': 'Unauthorized',
        'message': 'Your not authorized to access this resource',
        'status': HTTPStatus.UNAUTHORIZED
    }), HTTPStatus.UNAUTHORIZED
