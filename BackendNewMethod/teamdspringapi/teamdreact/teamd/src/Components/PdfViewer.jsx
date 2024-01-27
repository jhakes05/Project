import React, { useState, useEffect } from 'react';
import axios from 'axios';

const PdfViewer = () => {
  const [certificates, setCertificates] = useState([]);

  useEffect(() => {
    const fetchCertificates = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/certs');

        setCertificates(response.data);
      } catch (error) {
        console.error('Error fetching certificate data:', error);
      }
    };

    // Fetch certificate data when the component mounts
    fetchCertificates();
  }, []);

  return (
    <div>
      <h2>All Certificates</h2>
      <div style={{ display: 'flex', flexWrap: 'wrap' }}>
        {certificates.map((certificate) => (
          <div key={certificate.certID} style={{ margin: '10px', width: '300px', textAlign: 'center' }}>
            <iframe title={`Certificate ${certificate.certID}`} src={`http://localhost:8080/api/certs/${certificate.certID}/pdf`} width="100%" height="400px"></iframe>
            <p>Cert ID: {certificate.certID}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default PdfViewer;
