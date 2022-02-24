from application import db
from dataclasses import dataclass

@dataclass
class Person(db.Model):
    email:str
    name:str
    age:int
    company:str

    email = db.Column(db.String(100), primary_key = True)
    name = db.Column(db.String(50), nullable = False)
    age = db.Column(db.Integer)
    company = db.Column(db.String(50))

    def __init__(self, email, name, age, company):
        self.email = email
        self.name = name
        self.age = age
        self.company = company