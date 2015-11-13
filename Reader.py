class Reader(object):

	''' Leitor de saltos '''

	def __init__(self):
		self.resultadoLeitura = []

	# Lê o arquivo contido em caminhoParaArquivo e retorna uma cópia do resultado
	def read(self, caminhoParaArquivo):
		arquivo = open(caminhoParaArquivo, 'r')
		resultadoTemp = arquivo.readlines()
		for line in resultadoTemp:
			self.resultadoLeitura.append(line.rstrip('\n'))
		arquivo.closed
		return self.resultadoLeitura[:]