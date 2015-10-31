from Predicao import *

class PredicaoDeDoisBits(Predicao):

	''' Esta classe implementa uma predição de saltos de dois bits '''

	def __init__(self):
		contadorDeErros = 1
		Predicao.__init__(self)

	def predizer(self):
		for salto in self.listaDeSaltos:
			self.predicoesFeitas.append(self.proximaPredicao)
			if(salto == self.proximaPredicao):
				self.predicoesCorretas += 1
				contadorDeErros = 1
			else:
				contadorDeErros = (contadorDeErros + 1) % 3
				if(contadorDeErros == 0):
					self.setProximaPredicao()
					contadorDeErros = 1