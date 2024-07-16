import React, { useState } from 'react';
import 'tailwindcss/tailwind.css';
import MicroserviceTab from './MicroserviceTab'; // Correct import for default export
import ReactFlowRenderer from './ReactFlowRenderer'; // Correct import for default export

const App = () => {
  const [activeTab, setActiveTab] = useState('microservice1');

  const tabs = [
    { id: 'microservice1', label: 'Microservice 1' },
    { id: 'microservice2', label: 'Microservice 2' },
    // добавьте больше вкладок по мере необходимости
  ];

  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <div className="tabs">
        {tabs.map((tab) => (
          <button
            key={tab.id}
            onClick={() => setActiveTab(tab.id)}
            className={`tab ${activeTab === tab.id ? 'tab-active' : ''}`}
          >
            {tab.label}
          </button>
        ))}
      </div>
      <div className="tab-content mt-6">
        {activeTab === 'microservice1' && (
          <MicroserviceTab
            title="Microservice 1"
            description="Описание для Microservice 1"
          />
        )}
        {activeTab === 'microservice2' && (
          <MicroserviceTab
            title="Microservice 2"
            description="Описание для Microservice 2"
          />
        )}
      </div>
      <div className="flow-content mt-6">
        <ReactFlowRenderer />
      </div>
    </div>
  );
};

export default App;
