"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const sociosController_1 = require("../controllers/sociosController");
class SociosRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', sociosController_1.sociosController.list);
        this.router.get('/:id', sociosController_1.sociosController.getOne);
        this.router.post('/', sociosController_1.sociosController.create);
        this.router.delete('/:id', sociosController_1.sociosController.delete);
        this.router.put('/:id', sociosController_1.sociosController.update); //updat
    }
}
const sociosRoutes = new SociosRoutes();
exports.default = sociosRoutes.router;
