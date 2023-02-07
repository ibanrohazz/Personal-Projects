from flask_restful import Resource

from flask_restful import request
from flask_restful import reqparse
import json
from .swen_344_db_utils import *

class Tasks(Resource):
    def get(self):
        result = exec_get_all("SELECT * FROM tasks");
        return result
       

# class TestMessage(Resource):
#     def get(self):
#         return "Modal components can use onOpened to fetch data dynamically!"