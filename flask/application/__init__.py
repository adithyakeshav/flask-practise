from flask import Flask
from flask_restful import Api

# engine_id = "013608637834831325087:f2jdt7a6oyo"
# api_key = "AIzaSyCx-qnRu-CNSA5XVFB-4n1nnfNpl4tseEA"
# public_url = "https://cse.google.com/cse?cx=013608637834831325087:f2jdt7a6oyo"

app = Flask(__name__)
api = Api(app)

from application.apis.helloworld import HelloWorld

api.add_resource(HelloWorld, "/")
