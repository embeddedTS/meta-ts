FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://0001-QCA9377-HCI-UART-Support.patch \
    file://0002-QCA9377-UART-H4-IBS-Support-Baudrate-Fix.patch \
    file://0003-QCA9377-UART-Skip-NVM-BDADDR.patch \
    file://0004-Obex-Set-DBUS-Session-Service.patch \
    file://0005-Bluetoothd-Service-Enable-Compatibility-Mode.patch \
    file://0006-Fix-GATT-Glib-WARNING.patch \
"
