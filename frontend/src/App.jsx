import { Routes, Route } from 'react-router-dom'
import { motion, AnimatePresence } from 'framer-motion'
import Navbar from './components/Navbar'
import Sidebar from './components/Sidebar'
import Dashboard from './pages/Dashboard'
import Finance from './pages/Finance'
import Sales from './pages/Sales'
import Stock from './pages/Stock'
import Invoice from './pages/Invoice'

function App() {
  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar />
      <div className="flex">
        <Sidebar />
        <main className="flex-1 p-6">
          <AnimatePresence mode="wait">
            <Routes>
              <Route path="/" element={
                <motion.div
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -20 }}
                >
                  <Dashboard />
                </motion.div>
              } />
              <Route path="/finance" element={
                <motion.div
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -20 }}
                >
                  <Finance />
                </motion.div>
              } />
              <Route path="/sales" element={
                <motion.div
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -20 }}
                >
                  <Sales />
                </motion.div>
              } />
              <Route path="/stock" element={
                <motion.div
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -20 }}
                >
                  <Stock />
                </motion.div>
              } />
              <Route path="/invoice" element={
                <motion.div
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -20 }}
                >
                  <Invoice />
                </motion.div>
              } />
            </Routes>
          </AnimatePresence>
        </main>
      </div>
    </div>
  )
}

export default App 