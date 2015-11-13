class Predicao(object):

	''' Classe pai de todos os akinators de saltos '''

	def __init__(self):
		self.proximaPredicao = 'T'
		self.predicoesCorretas = 0
		self.predicoesFeitas = ''

	def setPredicoesCorretas(self, numeroDePredicoes):
		if (numeroDePredicoes < 0):
			return 'O número de acertos não pode ser negativo.'
		elif(numeroDePredicoes > len(self.predicoesFeitas)):
			return 'O número de acertos não pode ser maior que a quantidade de saltos.'
		else:
			self.predicoesCorretas = numeroDePredicoes

	def getPredicoesCorretas(self):
		return self.predicoesCorretas

	def getPorcentagemDeAcertos(self):
		return self.predicoesCorretas/len(self.predicoesFeitas)

	def getProximaPredicao(self):
		return self.proximaPredicao

	def setProximaPredicao(self, novaPred):
		if(novaPred == 'T' or novaPred == 'N'):
			self.proximaPredicao = novaPred
		else:
			return 'Entrada não é um salto permitido'

	def setPredicoesFeitas(self, novasPredicoes):
		self.predicoesFeitas = novasPredicoes

	def getPredicoesFeitas(self):
		stringPredicoesFeitas = ''
		for salto in self.predicoesFeitas:
			stringPredicoesFeitas += ' ' + salto
		return stringPredicoesFeitas

	def exibirResultados(self):
		print('Predições feitas:\t' + self.predicoesFeitas)
		print('Porcentagem de acertos:\t' + str(self.getPorcentagemDeAcertos()))

	def reset(self):
		self.setPredicoesFeitas('')
		self.setPredicoesCorretas(0)

	def predizer(self, listaDeSaltos):
		pass