import React from 'react';

const MicroserviceTab = ({ title, description }) => {
  return (
    <div className="p-4 bg-white shadow-md rounded">
      <h2 className="text-2xl font-bold mb-2">{title}</h2>
      <p>{description}</p>
      {/* добавьте дополнительную информацию здесь */}
    </div>
  );
};

export default MicroserviceTab;