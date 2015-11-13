class Predicao(object):

	''' Classe pai de todos os akinators de saltos '''

	def __init__(self):
		self.listaDeSaltos = []
		self.proximaPredicao = 'T'
		self.predicoesCorretas = 0
		self.predicoesFeitas = ''

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

	def setProximaPredicao(self, novaPred):
		if(novaPred == 'T' or novaPred == 'N'):
			self.proximaPredicao = novaPred
		else:
			return 'Entrada não é um salto permitido'

	def setListaDeSaltos(self, listaDeSaltos):
		arquiDeLeitura = open(listaDeSaltos, 'r+')
		self.listaDeSaltos = arquiDeLeitura.readline()
		arquiDeLeitura.closed

	def setPredicoesFeitas(self, novasPredicoes):
		self.predicoesFeitas = novasPredicoes

	def getPredicoesFeitas(self):
		stringPredicoesFeitas = ''
		for salto in self.predicoesFeitas:
			stringPredicoesFeitas += ' ' + salto
		return stringPredicoesFeitas

	def getListaDeSaltos(self):
		stringListaDeSaltos = ''
		for salto in self.listaDeSaltos:
			stringListaDeSaltos += ' ' + salto
		return stringListaDeSaltos

	def predizer(self):
		pass