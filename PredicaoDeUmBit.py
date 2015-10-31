from Predicao import *

class PredicaoDeUmBit(Predicao):

	''' Essa classe implementa uma prediçao de saltos com um bit '''

	def __init__(self):
		Predicao.__init__(self)

	def predizer(self):
		for salto in self.listaDeSaltos:
			self.predicoesFeitas.append(self.proximaPredicao)
			if(salto == self.proximaPredicao):
				self.predicoesCorretas += 1
			else:
				self.setProximaPredicao()