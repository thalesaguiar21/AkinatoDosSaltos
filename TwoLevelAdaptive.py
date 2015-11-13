from Predicao import *

class TwoLevelAdaptive(Predicao):

	''' Implementaçãode um algoritmo de predição de dois níveis '''

	def __init__(self):
		Predicao.__init__(self)
		self.tabelaDeHistoricos = {'TT' : 'T', 'TN' : 'T', 'NT' : 'T', 'NN' : 'T'}


	def predizer(self):
		counter = 0
		start = 0
		while counter < len(self.listaDeSaltos):
			if(counter < 2):
				self.predicoesFeitas += self.tabelaDeHistoricos['TT']
				if(self.tabelaDeHistoricos['TT'] == self.listaDeSaltos[counter]):
					self.predicoesCorretas += 1
			else:
				#print(self.listaDeSaltos[start:counter])
				self.predicoesFeitas += self.tabelaDeHistoricos[self.listaDeSaltos[start:counter]]
				if(self.tabelaDeHistoricos[self.listaDeSaltos[start:counter]] == self.listaDeSaltos[counter]):
					self.predicoesCorretas += 1
				else:
					self.tabelaDeHistoricos[self.listaDeSaltos[start:counter]] = self.listaDeSaltos[counter]
				start += 1
			counter += 1



