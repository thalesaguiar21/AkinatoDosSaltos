class Predicao(object):

	''' Classe pai de todos os akinators de saltos '''

	def __init__(self):
		self.listaDeSaltos = []
		self.proximaPredicao = 'N'
		self.predicoesCorretas = 0
		self.predicoesFeitas = []

	def setPredicoesCorretas(self, numeroDePredicoes):
		if (numeroDePredicoes < 0):
			return 'O número de acertos não pode ser negativo.'
		elif(numeroDePredicoes > len(listaDeSaltos)):
			return 'O número de acertos não pode ser maior que a quantidade de saltos.'
		else:
			self.predicoesCorretas += 1

	def getPredicoesCorretas(self):
		return self.predicoesCorretas

	def getPorcentagemDeAcertos(self):
		return self.predicoesCorretas/len(self.predicoesFeitas)

	def getProximaPredicao(self):
		return self.proximaPredicao

	def setProximaPredicao(self):
		if(self.proximaPredicao == 'T'):
			self.proximaPredicao = 'N'
		elif(self.proximaPredicao == 'N'):
			self.proximaPredicao = 'T'

	def setProximaPredicao(self, novaPred):
		self.proximaPredicao = novaPred

	def setListaDeSaltos(self, listaDeSaltos):
		arquiDeLeitura = open(listaDeSaltos, 'r+')
		self.listaDeSaltos = list(arquiDeLeitura.readline())
		arquiDeLeitura.closed

	def setPredicoesFeitas(self, novasPredicoes):
		self.predicoesFeitas = novasPredicoes

	def getPredicoesFeitas(self):
		return self.predicoesFeitas

	def getListaDeSaltos(self):
		return self.listaDeSaltos

	def predizer(self):
		pass
