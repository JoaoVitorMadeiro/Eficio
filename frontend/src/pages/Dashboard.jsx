import { motion } from 'framer-motion'
import { useQuery } from '@tanstack/react-query'
import axios from 'axios'

const stats = [
  { name: 'Vendas do Mês', value: 'R$ 45.231,89', change: '+12.5%', changeType: 'increase' },
  { name: 'Pedidos Pendentes', value: '23', change: '+2', changeType: 'increase' },
  { name: 'Produtos em Estoque', value: '1.234', change: '-3.2%', changeType: 'decrease' },
  { name: 'Faturamento Anual', value: 'R$ 543.123,00', change: '+8.1%', changeType: 'increase' }
]

function Dashboard() {
  const { data: recentSales, isLoading } = useQuery(['recentSales'], async () => {
    const response = await axios.get('/api/sales/recent')
    return response.data
  })

  return (
    <div className="space-y-6">
      <h1 className="text-2xl font-semibold text-gray-900">Dashboard</h1>
      
      <div className="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-4">
        {stats.map((stat) => (
          <motion.div
            key={stat.name}
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="bg-white overflow-hidden shadow rounded-lg"
          >
            <div className="p-5">
              <div className="flex items-center">
                <div className="flex-1">
                  <dt className="text-sm font-medium text-gray-500 truncate">{stat.name}</dt>
                  <dd className="mt-1 text-3xl font-semibold text-gray-900">{stat.value}</dd>
                </div>
                <div className={`px-2.5 py-0.5 rounded-full text-sm font-medium ${
                  stat.changeType === 'increase' ? 'bg-green-100 text-green-800' : 'bg-red-100 text-red-800'
                }`}>
                  {stat.change}
                </div>
              </div>
            </div>
          </motion.div>
        ))}
      </div>

      <div className="bg-white shadow rounded-lg">
        <div className="px-4 py-5 sm:p-6">
          <h2 className="text-lg font-medium text-gray-900">Vendas Recentes</h2>
          {isLoading ? (
            <div className="mt-4 text-center text-gray-500">Carregando...</div>
          ) : (
            <div className="mt-4">
              <div className="flow-root">
                <ul role="list" className="-my-5 divide-y divide-gray-200">
                  {recentSales?.map((sale) => (
                    <motion.li
                      key={sale.id}
                      initial={{ opacity: 0 }}
                      animate={{ opacity: 1 }}
                      className="py-4"
                    >
                      <div className="flex items-center space-x-4">
                        <div className="flex-1 min-w-0">
                          <p className="text-sm font-medium text-gray-900 truncate">
                            {sale.customerName}
                          </p>
                          <p className="text-sm text-gray-500">
                            {new Date(sale.date).toLocaleDateString()}
                          </p>
                        </div>
                        <div className="text-sm font-medium text-gray-900">
                          R$ {sale.amount.toFixed(2)}
                        </div>
                      </div>
                    </motion.li>
                  ))}
                </ul>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  )
}

export default Dashboard 