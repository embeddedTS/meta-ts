#
# Copyright (C) 2013-2022 Technologic Systems, Inc. dba embeddedTS
#

DESCRIPTION = "Create Basic Image Tasks"
PR = "r5"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-ts-basic \
    packagegroup-ts-basic-libs \
    packagegroup-ts-basic-utils \
    packagegroup-ts-basic-extended \
    packagegroup-ts-dev-utils \
    packagegroup-ts-multiuser \
    packagegroup-ts-initscripts \
    packagegroup-ts-sys-services \
    packagegroup-ts-script-lang \
    "

python __anonymous () {
    # For backwards compatibility after rename
    packages = d.getVar("PACKAGES", True).split()
    for pkg in packages:
        d.appendVar("RPROVIDES_%s" % pkg, pkg.replace("packagegroup-ts", "task-ts"))
        d.appendVar("RREPLACES_%s" % pkg, pkg.replace("packagegroup-ts", "task-ts"))
        d.appendVar("RCONFLICTS_%s" % pkg, pkg.replace("packagegroup-ts", "task-ts"))
}


RDEPENDS_packagegroup-ts-basic = "\
    packagegroup-ts-basic-libs \
    packagegroup-ts-basic-utils \
    packagegroup-ts-basic-extended \
    packagegroup-ts-dev-utils \
    packagegroup-ts-multiuser \
    packagegroup-ts-initscripts \
    packagegroup-ts-sys-services \
    packagegroup-ts-script-lang \
    "

RDEPENDS_packagegroup-ts-basic-libs = "\
    glib-2.0 \
    "

RDEPENDS_packagegroup-ts-basic-utils = "\
    bash \
    acl \
    attr \
    bc \
    coreutils \
    cpio \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-tune2fs \    
    ed \
    file \
    findutils \
    gawk \
    gmp \
    grep \
    makedevs \
    mktemp \
    net-tools \
    pax \
    popt \
    procps \
    psmisc \
    sed \
    tar \
    time \
    udev \
    util-linux \
    zlib \
    kernel-modules \
    "

RDEPENDS_packagegroup-ts-basic-extended = "\
    iproute2 \
    iputils \
    iptables \
    module-init-tools \
    openssl \
    vim-tiny \
    nano \
    wget \
    db \
    sqlite3 \
    "

RDEPENDS_packagegroup-ts-dev-utils = "\
    byacc \
    diffutils \
    make \
    patch \
    strace \
    ltrace \
    tcpdump \
    ldd \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    gcc \
    gcc-symlinks \
    gettext \
    intltool \
    libstdc++ \
    libtool \
    perl-module-re \
    perl-module-text-wrap \
    findutils \
    less \
    file \
    "

RDEPENDS_packagegroup-ts-initscripts = "\
    initscripts \
    sysvinit \
    ethtool \
    mingetty \
    sysklogd \
    ts-misc \
    "

RDEPENDS_packagegroup-ts-multiuser = "\
    cracklib \
    gzip \
    libuser \
    libpam \
    shadow \
    sudo \
    "

RDEPENDS_packagegroup-ts-sys-services = "\
    at \
    bzip2 \
    cronie \
    elfutils \
    gzip \
    less \
    libcap \
    libevent \
    logrotate \
    libpcre \
    rpcbind \
    sysfsutils \
    tcp-wrappers \
    tzdata \
    apache2 \
    mysql5 \
    vsftpd \
    ntp \
    ntp-utils \   
    avahi \    
    hostap-daemon \
    "

RDEPENDS_packagegroup-ts-script-lang = "\
    modphp \
    perl \
    python \
    "
