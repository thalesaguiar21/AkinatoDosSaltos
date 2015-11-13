from Predicao import *

class PredicaoDeDoisBits(Predicao):

	''' Esta classe implementa uma predição de saltos de dois bits '''

	def __init__(self):
		self.contadorDeErros = 0
		Predicao.__init__(self)

	def predizer(self):
		for salto in self.listaDeSaltos:
			self.predicoesFeitas += self.proximaPredicao

			if(salto == 'T'):
				if(self.contadorDeErros == 1):
					if(salto != self.proximaPredicao):
						self.contadorDeErros += 1
					else:
						self.contadorDeErros -= 1
						self.predicoesCorretas += 1
				elif(self.contadorDeErros == 0):
					if(salto != self.proximaPredicao):
						self.contadorDeErros += 1
					self.predicoesCorretas += 1
			else:
				if(self.contadorDeErros == 2):
					if(salto != self.proximaPredicao):
						self.contadorDeErros -= 1
					else:
						self.contadorDeErros += 1
						self.predicoesCorretas += 1
				elif(self.contadorDeErros == 3):
					if(salto != self.proximaPredicao):
						self.contadorDeErros -= 1
					self.predicoesCorretas += 1

			if(self.contadorDeErros < 2):
				self.setProximaPredicao('T')
			else:
				self.setProximaPredicao('N')