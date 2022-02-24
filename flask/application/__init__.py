from flask import Flask
from flask_restful import Api
from flask_sqlalchemy import SQLAlchemy

# engine_id = "013608637834831325087:f2jdt7a6oyo"
# api_key = "AIzaSyCx-qnRu-CNSA5XVFB-4n1nnfNpl4tseEA"
# public_url = "https://cse.google.com/cse?cx=013608637834831325087:f2jdt7a6oyo"

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://adithya:1234@mysql_db:3306/flask_db'
# app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://adithya:1234@localhost:3306/flask_db'
api = Api(app)
db = SQLAlchemy(app)

from application.apis.helloworld import HelloWorld

api.add_resource(HelloWorld, "/")

from application.apis.person import Fetch_person, Create_person
api.add_resource(Create_person, "/person")
api.add_resource(Fetch_person, "/person/<email_id>")
