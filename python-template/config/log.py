'''
File: config.py
Description: Contains various configuration methods for the project.
'''
import logging


def setup_logging():
    '''
    This function sets up the global logger for the service.
    '''
    formatter = logging.Formatter(
        fmt='%(asctime)s - %(levelname)s - %(module)s - %(message)s')

    handler = logging.StreamHandler()
    handler.setFormatter(formatter)

    logger = logging.getLogger('app')
    logger.setLevel(logging.DEBUG)
    logger.addHandler(handler)
