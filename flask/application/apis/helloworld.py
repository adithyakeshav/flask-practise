from flask import jsonify
from flask_restful import Resource

class HelloWorld(Resource):
    def get(self):
        return jsonify({"STATUS": "OK", "METHOD" : "GET", "MESSAGE" : "Hello World from Get Method"})

    def post(self):
        return jsonify({"STATUS": "OK", "METHOD": "POST", "MESSAGE" : "Hello World from Post method"})

