from flask import request, jsonify
from flask_restful import Resource
from application.models import Person
from application import db

class Fetch_person(Resource):
    def get(self, email_id):
        person = Person.query.filter_by(email=email_id).first()
        if person == None:
            return jsonify({"code":404, "message":"Given Person not found"})
        return jsonify(person)

    def delete(self, email_id):
        person = Person.query.filter_by(email=email_id).first()
        if person == None:
            return jsonify({"code":404, "message":"Given Person not found"})
        db.session.delete(person)
        db.session.commit()
        return jsonify(person)

class Create_person(Resource):
    def post(self):
        json_data = request.get_json(force=True)
        email = json_data.get('email')
        person = Person.query.filter_by(email=email).first()
        if person == None:
            person = Person(email,json_data.get('name'),json_data.get('age'),json_data.get('company'))
        else:
            person.age = json_data.get('age')
            person.company = json_data.get('company')
            person.name = json_data.get('name')
        db.session.add(person)
        db.session.commit()
        print(person)
        return jsonify(person)
    
    def get(self):
        persons = Person.query.all()
        return jsonify(persons)
