from Predicao import *

class TwoLevelAdaptive(Predicao):

	''' Implementaçãode um algoritmo de predição de dois níveis '''

	def __init__(self):
		Predicao.__init__(self)
		self.tabelaDeHistoricos = {'TT' : 'T', 'TN' : 'T', 'NT' : 'T', 'NN' : 'T'}

	def reset(self):
		Predicao.reset(self)
		self.tabelaDeHistoricos = {'TT' : 'T', 'TN' : 'T', 'NT' : 'T', 'NN' : 'T'}

	def predizer(self, listaDeSaltos):
		counter = 0
		start = 0
		while counter < len(listaDeSaltos):
			if(counter < 2):
				self.predicoesFeitas += self.tabelaDeHistoricos['TT']
				if(self.tabelaDeHistoricos['TT'] == listaDeSaltos[counter]):
					self.predicoesCorretas += 1
			else:
				self.predicoesFeitas += self.tabelaDeHistoricos[listaDeSaltos[start:counter]]
				if(self.tabelaDeHistoricos[listaDeSaltos[start:counter]] == listaDeSaltos[counter]):
					self.predicoesCorretas += 1
				else:
					self.tabelaDeHistoricos[listaDeSaltos[start:counter]] = listaDeSaltos[counter]
				start += 1
			counter += 1



