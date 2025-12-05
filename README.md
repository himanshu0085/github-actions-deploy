
# 🚀 Portfolio Website — Kubernetes Deployment using Minikube

This project deploys a static portfolio website (Nginx-based) to a Kubernetes cluster using **Docker + Minikube**.

---

## 📂 Project Structure

```
├── Dockerfile
├── index.html
├── styles.css
└── k8s
    ├── deployment.yaml
    └── service.yaml
```

---

## 🛠 Prerequisites

| Tool | Version |
|------|---------|
| Docker | ≥ 20.x |
| Minikube | ≥ 1.30 |
| kubectl | Installed |
| GitHub Actions (optional CI/CD) | Configured |

---

## 🧱 1. Build Docker Image

```bash
docker build -t <dockerhub-username>/portfolio:latest .
```

Push to Docker Hub:

```bash
docker push <dockerhub-username>/portfolio:latest
```

---

## ☸ 2. Start Minikube

> ⚠ Important: Allow NodePort to be reachable from host

```bash
minikube start --driver=docker --ports=30080:30080
```

Verify cluster status:

```bash
kubectl get nodes
```

---

## 📦 3. Deploy Application to Kubernetes

```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

Check pod status:

```bash
kubectl get pods
```

Check service:

```bash
kubectl get svc portfolio-service
```

Expected output:

```
portfolio-service   NodePort   ...   80:30080/TCP
```

---

## 🌍 4. Access Website in Browser

Find the host/server IP:

```bash
hostname -I
```

Then open in browser:

```
http://<server-ip>:30080
```

Example:

```
http://192.168.8.167:30080
```

---

## 🧪 Troubleshooting

### 🔹 Pod running but browser not opening
Check pod logs:

```bash
kubectl logs -l app=portfolio-app
```

### 🔹 `curl` inside server works but browser cannot access
Firewall may block the port:

```bash
sudo ufw allow 30080
```

### 🔹 Minikube NodePort not reachable
Recreate cluster with correct port mapping:

```bash
minikube stop
minikube delete
minikube start --driver=docker --ports=30080:30080
```

---

## 💡 Extra (Optional)

### Expose service temporarily using `minikube service`

```bash
minikube service portfolio-service --url
```

### Port-forward without exposing NodePort

```bash
kubectl port-forward svc/portfolio-service 8080:80
# Open browser: http://<server-ip>:8080
```

---

## 🤝 Contribution

If you want to improve the UI or deployment workflow, feel free to open a PR!

---

## 📜 License

MIT — free to use and modify.
