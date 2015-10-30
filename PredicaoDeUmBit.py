from Predicao import *

class PredicaoDeUmBit(Predicao):

	''' Essa classe implementa uma prediçao de saltos com um bit '''

	def __init__(self):
		Predicao.__init__(self)

	def predizer(self):
		predicoesFeitas = ''
		for salto in self.listaDeSaltos:
			predicoesFeitas += self.proximaPredicao
			if(salto == self.proximaPredicao):
				self.predicoesCorretas += 1
			else:
				self.setProximaPredicao()
		self.predicoesFeitas.append(' {} '.format(predicoesFeitas))