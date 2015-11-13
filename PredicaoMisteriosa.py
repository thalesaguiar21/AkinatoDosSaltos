from Predicao import *

class PredicaoMisteriosa(Predicao):

	''' Predicao baseada na frequência do histórico de saltos '''

	def __init__(self):
		Predicao.__init__(self)
		self.freqDeSaltosTomados = 0

	def predizer(self, listaDeSaltos):
		for salto in listaDeSaltos:
			self.predicoesFeitas += self.proximaPredicao
			# Atualiza a frequência de saltos
			if(salto == 'T'):
				self.freqDeSaltosTomados += 1
			if(self.proximaPredicao == salto):
				self.predicoesCorretas += 1
			# Atualiza a porcentagem de saltos
			self.porcDeSaltosTomados = self.freqDeSaltosTomados/len(self.predicoesFeitas)
			# Verifica se é necessário alterar a próxima predição
			if(self.porcDeSaltosTomados < 0.5):
				self.setProximaPredicao('N')
			else:
				self.setProximaPredicao('T')