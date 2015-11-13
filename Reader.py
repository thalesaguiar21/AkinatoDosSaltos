class Reader(object):

	''' Leitor de saltos '''

	def __init__(self):
		self.resultadoLeitura = ''

	# Lê o arquivo contido em caminhoParaArquivo e retorna uma cópia do resultado
	def read(caminhoParaArquivo):
		arquivo = open(caminhoParaArquivo, 'r+')
		self.resultadoLeitura = arquivo.read()
		arquivo.closed
		return self.resultadoLeitura[:]