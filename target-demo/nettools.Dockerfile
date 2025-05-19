FROM ubuntu:22.04

# Install essential tools with minimal extra packages
RUN apt-get update && apt-get install -y --no-install-recommends \
    telnet \
    netcat-openbsd \
    lsof \
    net-tools \
    curl \
    iputils-ping \
    dnsutils \
    && rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Keep container running for troubleshooting
CMD ["sleep", "infinity"]